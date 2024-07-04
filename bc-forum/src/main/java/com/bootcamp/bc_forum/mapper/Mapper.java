package com.bootcamp.bc_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.bootcamp.bc_forum.entity.CommentEntity;
import com.bootcamp.bc_forum.entity.PostEntity;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.ForumDTO.CommentDTO;
import com.bootcamp.bc_forum.model.ForumDTO.ForumCommentDTO;
import com.bootcamp.bc_forum.model.ForumDTO.ForumPostDTO;
import com.bootcamp.bc_forum.model.ForumDTO.ForumUserDTO;
import com.bootcamp.bc_forum.model.placeholder.CommentRespDto;
import com.bootcamp.bc_forum.model.placeholder.PostRespDto;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;

@Component
public class Mapper {
        public ForumUserDTO map(UserRespDto userReqDto) {

                ForumUserDTO.Address.Geo geo = ForumUserDTO.Address.Geo
                                .builder()//
                                .lat(userReqDto.getAddress().getGeo().getLat())//
                                .lng(userReqDto.getAddress().getGeo().getLng())//
                                .build();

                ForumUserDTO.Address add = ForumUserDTO.Address.builder()//
                                .street(userReqDto.getAddress().getStreet())//
                                .suite(userReqDto.getAddress().getSuite())//
                                .city(userReqDto.getAddress().getCity())//
                                .zipcode(userReqDto.getAddress().getZipcode())//
                                .geo(geo)//
                                .build();


                ForumUserDTO.Company company = ForumUserDTO.Company.builder()//
                                .name(userReqDto.getCompany().getName())//
                                .catchPhrase(userReqDto.getCompany()
                                                .getCatchPhrase())//
                                .bs(userReqDto.getCompany().getBs())//
                                .build();

                return ForumUserDTO.builder()//
                                .id(userReqDto.getId())//
                                .name(userReqDto.getName())//
                                .username(userReqDto.getUsername()).address(add)//
                                .email(userReqDto.getEmail())//
                                .phone(userReqDto.getPhone())//
                                .website(userReqDto.getWebsite())//
                                .company(company)//
                                .build();

        }


        public ForumPostDTO map(PostRespDto postReqDto) {
                return ForumPostDTO.builder()//
                                .userId(postReqDto.getUserId())//
                                .id(postReqDto.getId())//
                                .title(postReqDto.getTitle())//
                                .body(postReqDto.getBody())//
                                .build();
        }

        public ForumCommentDTO map(CommentRespDto commentReqDto) {
                return ForumCommentDTO.builder()//
                                .postId(commentReqDto.getPostId())//
                                .id(commentReqDto.getId())//
                                .name(commentReqDto.getName())//
                                .email(commentReqDto.getEmail())//
                                .body(commentReqDto.getBody())//
                                .build();
        }

        public ForumPostDTO map(PostRespDto post,
                        List<ForumCommentDTO> collect) {
                return ForumPostDTO.builder()//
                                .userId(post.getUserId())//
                                .id(post.getId())//
                                .title(post.getTitle())//
                                .body(post.getBody())//
                                .comment(collect)//
                                .build();
        }


        public ForumUserDTO map(UserRespDto userRespDto,
                        List<ForumPostDTO> collect) {
                ForumUserDTO user = this.map(userRespDto);
                user.setPost(collect);
                return user;

        }

        public CommentDTO map(ForumCommentDTO forumCommentDTO) {
                return CommentDTO.builder()//
                                .name(forumCommentDTO.getName())//
                                .email(forumCommentDTO.getEmail())//
                                .body(forumCommentDTO.getBody())//
                                .build();
        }

        public UserEntity mapToEntity(UserRespDto userRespDto) {
                return UserEntity.builder()//
                                .id(userRespDto.getId())//
                                .name(userRespDto.getName())//
                                .username(userRespDto.getUsername())//
                                .email(userRespDto.getEmail())//
                                .phone(userRespDto.getPhone())//
                                .website(userRespDto.getWebsite())//
                                .street(userRespDto.getAddress().getStreet())//
                                .suite(userRespDto.getAddress().getSuite())//
                                .city(userRespDto.getAddress().getCity())//
                                .zipcode(userRespDto.getAddress().getZipcode())//
                                .lat(userRespDto.getAddress().getGeo().getLat())//
                                .lng(userRespDto.getAddress().getGeo().getLng())//
                                .companyName(userRespDto.getCompany().getName())//
                                .companyCatchPhrase(userRespDto.getCompany()
                                                .getCatchPhrase())//
                                .companyBs(userRespDto.getCompany().getBs())//
                                .build();
        }

        public PostEntity mapToEntity(PostRespDto postRespDto,
                        UserEntity userEntity) {
                return PostEntity.builder()//
                                .id(postRespDto.getId())//
                                .title(postRespDto.getTitle())//
                                .body(postRespDto.getBody())//
                                .user(userEntity)//
                                .build();
        }

        public CommentEntity mapToEntity(CommentRespDto commentRespDto,
                        PostEntity postEntity) {
                return CommentEntity.builder()//
                                .id(commentRespDto.getId())//
                                .name(commentRespDto.getName())//
                                .email(commentRespDto.getEmail())//
                                .body(commentRespDto.getBody())//
                                .post(postEntity)//
                                .build();
        }


        public UserRespDto map(UserEntity userEntity) {
                UserRespDto.Address.Geo geo = UserRespDto.Address.Geo.builder()//
                                .lat(userEntity.getLat())//
                                .lng(userEntity.getLng())//
                                .build();

                UserRespDto.Address add = UserRespDto.Address.builder()//
                                .street(userEntity.getStreet())//
                                .suite(userEntity.getSuite())//
                                .city(userEntity.getCity())//
                                .zipcode(userEntity.getZipcode())//
                                .geo(geo)//
                                .build();

                UserRespDto.Company company = UserRespDto.Company.builder()//
                                .name(userEntity.getCompanyName())//
                                .catchPhrase(userEntity.getCompanyCatchPhrase())//
                                .bs(userEntity.getCompanyBs())//
                                .build();

                return UserRespDto.builder()//
                                .id(userEntity.getId())//
                                .name(userEntity.getName())//
                                .username(userEntity.getUsername())//
                                .email(userEntity.getEmail())//
                                .phone(userEntity.getPhone())//
                                .website(userEntity.getWebsite())//
                                .address(add)//
                                .company(company)//
                                .build();

        }

}
