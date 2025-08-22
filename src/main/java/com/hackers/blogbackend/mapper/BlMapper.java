package com.hackers.blogbackend.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hackers.blogbackend.dto.ActivityLogDto;
import com.hackers.blogbackend.dto.AiRecommendationDto;
import com.hackers.blogbackend.dto.BadgeDto;
import com.hackers.blogbackend.dto.CategoryDto;
import com.hackers.blogbackend.dto.CommentDto;
import com.hackers.blogbackend.dto.InlineCommentDto;
import com.hackers.blogbackend.dto.NotificationDto;
import com.hackers.blogbackend.dto.PostDto;
import com.hackers.blogbackend.dto.QuizBlockDto;
import com.hackers.blogbackend.dto.ReactionDto;
import com.hackers.blogbackend.dto.TagDto;
import com.hackers.blogbackend.dto.UserDto;
import com.hackers.blogbackend.dto.postdto.PostCreateDto;
import com.hackers.blogbackend.entity.ActivityLog;
import com.hackers.blogbackend.entity.AiRecommendation;
import com.hackers.blogbackend.entity.Badge;
import com.hackers.blogbackend.entity.Category;
import com.hackers.blogbackend.entity.Comment;
import com.hackers.blogbackend.entity.InlineComment;
import com.hackers.blogbackend.entity.Notification;
import com.hackers.blogbackend.entity.Post;
import com.hackers.blogbackend.entity.QuizBlock;
import com.hackers.blogbackend.entity.Reaction;
import com.hackers.blogbackend.entity.Tag;
import com.hackers.blogbackend.entity.User;

@Mapper(componentModel = "spring")
public interface BlMapper {
    
    /**
     * Maps a User entity to a UserDto.
     *
     * @param user the User entity to map
     * @return the mapped UserDto
     */
    @Mapping(target = "roles", expression = "java(user.getRoles().stream().map(r -> r.getName()).collect(java.util.stream.Collectors.toSet()))")
    UserDto maps(User user);

    /**
     * Maps a UserDto to a User entity.
     *
     * @param userDto the UserDto to map
     * @return the mapped User entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "roles", ignore = true) 
    @Mapping(target = "badges", ignore = true) 
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    User maps(UserDto userDto);

    /**
     * Maps a Post entity to a PostDto.
     *
     * @param post the Post entity to map
     * @return the mapped PostDto
     */
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "tags", expression = "java(post.getTags().stream().map(tag -> tag.getName()).collect(java.util.stream.Collectors.toSet()))")
    PostDto maps(Post post);



    @InheritInverseConfiguration
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    @Mapping(target = "aiSummary", ignore = true)
    @Mapping(target = "estimateTimeToRead", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "slug", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "category", ignore = true)
    Post maps(PostCreateDto PostCreateDto);

    /**
     * Maps a Category entity to a CategoryDto.
     *
     * @param category the Category entity to map
     * @return the mapped CategoryDto
     */
    Category maps(Category category);

    /**
     * Maps a CategoryDto to a Category entity.
     *
     * @param categoryDto the CategoryDto to map
     * @return the mapped Category entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    Category maps(CategoryDto categoryDto);

    /**
     * Maps a Comment entity to a CommentDto.
     *
     * @param comment the Comment entity to map
     * @return the mapped CommentDto
     */
    @Mapping(target = "postId", source = "post.id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "parentId", source = "parentComment.id")
    CommentDto maps(Comment comment);

    /**
     * Maps a CommentDto to a Comment entity.
     *
     * @param commentDto the CommentDto to map
     * @return the mapped Comment entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "post", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "parentComment", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    Comment maps(CommentDto commentDto);

    /**
     * Maps an InlineComment entity to an InlineCommentDto.
     *
     * @param inlineComment the InlineComment entity to map
     * @return the mapped InlineCommentDto
     */
    @Mapping(target = "postId", source = "post.id")
    @Mapping(target = "userId", source = "user.id")
    InlineCommentDto maps(InlineComment inlineComment);

    /**
     * Maps an InlineCommentDto to an InlineComment entity.
     *
     * @param inlineCommentDto the InlineCommentDto to map
     * @return the mapped InlineComment entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "post", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    InlineComment maps(InlineCommentDto inlineCommentDto);

    /**
     * Maps a Reaction entity to a ReactionDto.
     *
     * @param reaction the Reaction entity to map
     * @return the mapped ReactionDto
     */
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "postId", source = "post.id")
    @Mapping(target = "commentId", source = "comment.id")
    ReactionDto maps(Reaction reaction);

    /**
     * Maps a ReactionDto to a Reaction entity.
     *
     * @param reactionDto the ReactionDto to map
     * @return the mapped Reaction entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "post", ignore = true)
    @Mapping(target = "comment", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    Reaction maps(ReactionDto reactionDto);

    /**
     * Maps a Notification entity to a NotificationDto.
     *
     * @param notification the Notification entity to map
     * @return the mapped NotificationDto
     */
    
    NotificationDto maps(Notification notification);

    /**
     * Maps a NotificationDto to a Notification entity.
     *
     * @param notificationDto the NotificationDto to map
     * @return the mapped Notification entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    Notification maps(NotificationDto notificationDto);

    /**
     * Maps a Badge entity to a BadgeDto.
     *
     * @param badge the Badge entity to map
     * @return the mapped BadgeDto
     */
    BadgeDto maps(Badge badge);

    /**
     * Maps a BadgeDto to a Badge entity.
     *
     * @param badgeDto the BadgeDto to map
     * @return the mapped Badge entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    Badge maps(BadgeDto badgeDto);

    /**
     * Maps a Tag entity to a TagDto.
     *
     * @param tag the Tag entity to map
     * @return the mapped TagDto
     */
    TagDto maps(Tag tag);

    /**
     * Maps a TagDto to a Tag entity.
     *
     * @param tagDto the TagDto to map
     * @return the mapped Tag entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    Tag maps(TagDto tagDto);

    /**
     * Maps a QuizBlock entity to a QuizBlockDto.
     *
     * @param quizBlock the QuizBlock entity to map
     * @return the mapped QuizBlockDto
     */
    QuizBlockDto maps(QuizBlock quizBlock);

    /**
     * Maps a QuizBlockDto to a QuizBlock entity.
     *
     * @param quizBlockDto the QuizBlockDto to map
     * @return the mapped QuizBlock entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    QuizBlock maps(QuizBlockDto quizBlockDto);

    /**
     * Maps an AiRecommendation entity to an AiRecommendationDto.
     *
     * @param aiRecommendation the AiRecommendation entity to map
     * @return the mapped AiRecommendationDto
     */
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "postId", source = "post.id")
    AiRecommendationDto maps(AiRecommendation aiRecommendation);

    /**
     * Maps an AiRecommendationDto to an AiRecommendation entity.
     *
     * @param aiRecommendationDto the AiRecommendationDto to map
     * @return the mapped AiRecommendation entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "post", ignore = true)
    AiRecommendation maps(AiRecommendationDto aiRecommendationDto);

    /**
     * Maps an ActivityLog entity to an ActivityLogDto.
     *
     * @param activityLog the ActivityLog entity to map
     * @return the mapped ActivityLogDto
     */
    @Mapping(target = "userId", source = "user.id")
    ActivityLogDto maps(ActivityLog activityLog);

    /**
     * Maps an ActivityLogDto to an ActivityLog entity.
     *
     * @param activityLogDto the ActivityLogDto to map
     * @return the mapped ActivityLog entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "statut", ignore = true)
    ActivityLog maps(ActivityLogDto activityLogDto);

}
