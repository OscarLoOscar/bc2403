package com.bootcamp.bc_forum.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.ForumResponse;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;
import com.bootcamp.bc_forum.repository.UserRepository;
import com.bootcamp.bc_forum.service.impl.UserServiceHolder;

@SpringBootTest
public class UserServiceHolderTest {

    @InjectMocks
    private UserServiceHolder userServiceHolder;

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private UserRepository userRepository;

    private String userUrl = "https://jsonplaceholder.typicode.com/users";

    private UserRespDto user1;
    private UserRespDto user2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        user1 = new UserRespDto(1L, "name1", "username1", "email1",
                new UserRespDto.Address("street1", "suite1", "city1", "zipcode1",
                        new UserRespDto.Address.Geo("lat1", "lng1")),
                "phone1", "website1",
                new UserRespDto.Company("name1", "catchPhrase1", "bs1"));

        user2 = new UserRespDto(2L, "name2", "username2", "email2",
                new UserRespDto.Address("street2", "suite2", "city2", "zipcode2",
                        new UserRespDto.Address.Geo("lat2", "lng2")),
                "phone2", "website2",
                new UserRespDto.Company("name2", "catchPhrase2", "bs2"));
    }

    @Test
    public void testGetAll() {
        UserRespDto[] users = {user1, user2};
        when(restTemplate.getForObject(userUrl, UserRespDto[].class)).thenReturn(users);

        List<UserRespDto> result = userServiceHolder.getAllDataByAPI();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("name1", result.get(0).getName());
        assertEquals("name2", result.get(1).getName());
    }

    @Test
    public void testGetById() {
        when(restTemplate.getForObject(userUrl, UserRespDto[].class)).thenReturn(new UserRespDto[] {user1});

        UserRespDto result = userServiceHolder.getById(1L);

        assertNotNull(result);
        assertEquals("name1", result.getName());
    }

    @Test
    public void testDeleteById() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        UserEntity result = userServiceHolder.deleteById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testFindNameById() {
        ForumResponse ForumResponse = new ForumResponse();
        ForumResponse.setUsername("John");
        when(userRepository.findNameById(1L)).thenReturn(Arrays.asList(ForumResponse));

        List<ForumResponse> result = userServiceHolder.findNameById(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getUsername());
    }
}