package com.atifpathan.content_calendar.repository;

import com.atifpathan.content_calendar.model.Content;
import com.atifpathan.content_calendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword); // using query derivation --> CHECK DOCS FOR THIS

//    @Query("""
//            SELECT * FROM Content
//            where status = :status
//            """)
//    List<Content> listByStatus(@Param("status") Status status);
}
