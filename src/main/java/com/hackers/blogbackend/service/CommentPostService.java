package com.hackers.blogbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackers.blogbackend.dto.CommentDto;
import com.hackers.blogbackend.entity.Comment;
import com.hackers.blogbackend.entity.enom.EStatut;
import com.hackers.blogbackend.mapper.BlMapper;
import com.hackers.blogbackend.repository.CommentRepository;
import com.hackers.blogbackend.service.interfaces.CommentServiceInterface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentPostService implements CommentServiceInterface{

    private final CommentRepository commentRepository;
    private final BlMapper mapper;

    /**
     * Recuperation de touts les commentaires d'un post.
     * @postId l'identifiant du post
     * @return la liste des commentaires du post
     */
    @Override
    public List<CommentDto> getPostComments(String postId) {
        return commentRepository.findByPostId(postId).stream()
                                                .map(mapper::maps)
                                                .toList();
    }

    /**
     * Recuperation d'un commentaire.
     * @id l'identifiant du commentaire
     * @return le commentaire si trouvé, ou une exception si non trouvé
     */
    @Override
    public CommentDto getCommentById(String id) throws Exception {
            checkExist(id);
            return mapper.maps(commentRepository.findById(id).get());
        
    }

    /**
     * Creation d'un commentaire.
     * @commentDto le commentaire a creer
     * @return le commentaire cree
     */
    @Override
    public CommentDto doPostComment(CommentDto commentDto) {
        return mapper.maps(this.commentRepository.save(mapper.maps(commentDto)));
    }

    /**
     * Mise a jour d'un commentaire.
     * @id l'identifiant du commentaire a mettre a jour
     * @commentDto le commentaire a mettre a jour
     * @return le commentaire mis a jour
     */
    @Override
    public CommentDto doUpdateComment(String id, CommentDto commentDto) {
        Comment comment = mapper.maps(commentDto);
        comment.setId(id);
        return mapper.maps(this.commentRepository.save(comment));
    }

    /**
     * Suppression logique des commentaires.
     * @id l'identifiant du commentaire a supprimer
     */
    @Override
    public void deleteCommentById(String id) throws Exception {
        checkExist(id);
        Comment comment = commentRepository.findByIdAndStatut(id,EStatut.ACTIVE).get();
        comment.setStatut(EStatut.SUPPRIMER);
        commentRepository.save(comment);
    }


    /**
     * Verification de l'existance du commentaire.
     * @id l'identifiant du commentaire en question
     */
    private void checkExist(String id) throws Exception{
        if (!commentRepository.existsById(id)) {
            throw new Exception("aucun commentaire avec ce identifiant n'existe");
        }
    }

}
