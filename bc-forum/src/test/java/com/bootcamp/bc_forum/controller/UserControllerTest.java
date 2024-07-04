package com.bootcamp.bc_forum.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.bootcamp.bc_forum.controller.impl.UserController;
import com.bootcamp.bc_forum.mapper.Mapper;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;
import com.bootcamp.bc_forum.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @MockBean
  private ModelMapper modelMapper;

  @MockBean
  private Mapper mapper;

  private UserRespDto userRespDto;
  private List<UserRespDto> userRespDtoList;

  @BeforeEach
  void setUp() {
    userRespDto = new UserRespDto();
    userRespDto.setId(1L);
    userRespDto.setName("John Doe");

    userRespDtoList = Arrays.asList(userRespDto);

    given(modelMapper.map(userService.getById(1L), UserRespDto.class))
        .willReturn(userRespDto);
    given(userService.getAllDataByAPI()).willReturn(Arrays.asList(new UserRespDto()));
    given(modelMapper.map(userService.getAllDataByAPI().get(0), UserRespDto.class))
        .willReturn(userRespDto);
  }

  @Test
  void getAll_ShouldReturnUserList() throws Exception {
    mockMvc.perform(get("/placeholder/v1/users"))//
        .andExpect(status().isFound())//
        .andExpect(jsonPath("$.data[0][0].id").value(userRespDto.getId()))
        .andExpect(jsonPath("$.data[0][0].name").value(userRespDto.getName()));
  }

  @Test
  void getById_ShouldReturnUser() throws Exception {
    mockMvc.perform(get("/placeholder/v1/user/1"))//
        .andExpect(status().isFound())//
        .andExpect(jsonPath("$.data[0].id").value(userRespDto.getId()))
        .andExpect(jsonPath("$.data[0].name").value(userRespDto.getName()));
  }

  @Test
  void findNameById_ShouldReturnUserNames() throws Exception {
    mockMvc.perform(get("/placeholder/v1?id=1"))
        .andExpect(status().isFound());
  }
}
