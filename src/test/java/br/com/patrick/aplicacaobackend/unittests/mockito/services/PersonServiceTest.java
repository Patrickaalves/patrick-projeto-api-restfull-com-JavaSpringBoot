package br.com.patrick.aplicacaobackend.unittests.mockito.services;

import br.com.patrick.aplicacaobackend.domain.services.PersonService;
import br.com.patrick.aplicacaobackend.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    MockPerson input;

    @InjectMocks
    private PersonService service;

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testCreatePerson() {
    }

    @Test
    void testCreatePersonV2() {
    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindAll() {
    }

    @Test
    void testUpdatePerson() {
    }

    @Test
    void testDeletePerson() {
    }
}
