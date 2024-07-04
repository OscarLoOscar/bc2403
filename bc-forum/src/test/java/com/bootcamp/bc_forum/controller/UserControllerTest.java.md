package com.bootcamp.bc_forum.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach; // Add this import
import org.junit.jupiter.api.Test; // Add this import
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.bootcamp.bc_forum.controller.impl.UserController;
import com.bootcamp.bc_forum.infra.exceptions.SysCode;
import com.bootcamp.bc_forum.infra.response.ApiResp;
import com.bootcamp.bc_forum.model.UserRespDto;
import com.bootcamp.bc_forum.model.placeholder.UserReqDto;
import com.bootcamp.bc_forum.model.placeholder.UserReqDto.Address;
import com.bootcamp.bc_forum.model.placeholder.UserReqDto.Address.Geo;
import com.bootcamp.bc_forum.model.placeholder.UserReqDto.Company;
import com.bootcamp.bc_forum.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private ModelMapper mapper;

    private UserReqDto u1;
    private UserReqDto u2;

    private UserRespDto ur1;
    private UserRespDto ur2;

    @BeforeEach
    void setUp() {
        Geo u1Geo = new Geo("lat1", "lng1");
        Address u1Add =
                new Address("street1", "suite1", "city1", "zipcode1", u1Geo);
        Company u1Com = new Company("company1", "catchPhrase1", "bs1");
        u1 = new UserReqDto();
        u1.setId(1L);
        u1.setName("John");
        u1.setUsername("u1");
        u1.setEmail("john.u1@test1.com");
        u1.setPhone("12345678");
        u1.setWebsite("www.testing.com");
        u1.setAddress(u1Add);
        u1.setCompany(u1Com);

        u2 = new UserReqDto();
        u2.setId(2L);
        u2.setName("Vincent");
        u2.setUsername("u2");
        u2.setEmail("vincent.u2@test1.com");
        u2.setPhone("87654321");
        u2.setWebsite("www.testing123.com");
        Address u2Address =
                new Address("street2", "suite2", "city2", "zipcode2", //
                        new Geo("lat2", "lng2"));
        u2.setAddress(u2Address);
        Company u2Company = new Company("company2", "catchPhrase2", "bs2");
        u2.setCompany(u2Company);

        ur1 = new UserRespDto();
        ur1.setId(1L);
        ur1.setName("John");
        ur1.setUsername("u1");
        ur1.setEmail("john.u1@test1.com");
        ur1.setPhone("12345678");
        ur1.setWebsite("www.testing.com");

        ur2 = new UserRespDto();
        ur2.setId(2L);
        ur2.setName("Vincent");
        ur2.setUsername("u2");
        ur2.setEmail("vincent.u2@test1.com");
        ur2.setPhone("87654321");
        ur2.setWebsite("www.testing123.com");
    }

    @Test
    void testGetAll() throws Exception {
        List<UserReqDto> users = new ArrayList<>(List.of(u1, u2));

        when(userService.getAll()).thenReturn(users);
        // when(mapper.map(u1, UserRespDto.class)).thenReturn(ur1);
        // when(mapper.map(u2, UserRespDto.class)).thenReturn(ur2);

        mockMvc.perform(get("/placeholder/v1/users"))//
                .andExpect(status().isFound())//
                .andExpect(jsonPath("$.code").value(SysCode.SUCCESS.getCode()))//
                .andExpect(
                        jsonPath("$.message").value(SysCode.SUCCESS.getDesc()))//
                .andExpect(jsonPath("$.data[0].length()").value(2))//
                .andExpect(jsonPath("$.data[0][0].id").value(1L))//
                .andExpect(jsonPath("$.data[0][0].name").value("John"))//
                .andExpect(jsonPath("$.data[0][1].id").value(2L))//
                .andExpect(jsonPath("$.data[0][1].name").value("Vincent"));
    }

    @Test
    void testGetById() throws Exception {
        when(userService.getById(1L)).thenReturn(u1);
        when(mapper.map(u1, UserRespDto.class)).thenReturn(ur1);

        ApiResp<UserRespDto> apiResp = ApiResp.<UserRespDto>builder()//
                .ok()//
                .data(ur1)//
                .build();

        mockMvc.perform(get("/placeholder/v1/user/1"))//
                .andExpect(status().isFound())//
                .andExpect(jsonPath("$.code").value(SysCode.SUCCESS.getCode()))//
                .andExpect(
                        jsonPath("$.message").value(SysCode.SUCCESS.getDesc()))//
                .andExpect(jsonPath("$.data.length()").value(1))//
                .andExpect(jsonPath("$.data[0].name").value("John"));
    }
}
