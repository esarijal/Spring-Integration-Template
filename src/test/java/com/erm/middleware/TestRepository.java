package com.erm.middleware;

import com.erm.middleware.entity.TestEntity;
import com.erm.middleware.repository.TestEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestRepository {

    @Autowired
    private TestEntityRepository repository;

    @Test
    public void testFlow(){
        repository.save(new TestEntity(1L, "Esa Rijal", "Something long is here"));
        assertThat(repository.count(), is(1L));

        Optional<TestEntity> byId = repository.findById(1L);
        assertTrue(byId.isPresent());
        assertThat(byId.get().getName(), is("Esa Rijal"));

        repository.delete(byId.get());
        assertThat(repository.count(), is(0L));
    }
}
