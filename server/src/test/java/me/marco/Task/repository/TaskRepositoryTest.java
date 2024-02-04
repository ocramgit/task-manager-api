package me.marco.Task.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.marco.Task.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void testCreateUserWithSuccess() throws Exception {
        when(taskRepository.save(any(Task.class))).thenReturn(new Task());

        ObjectMapper objectMapper = new ObjectMapper();
        String objectTask = objectMapper.writeValueAsString(new Task());

        mockMvc.perform(post("/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectTask))
                .andExpect(status().isCreated());
    }
}
