//package com.atifpathan.content_calendar.repository;
//
//import com.atifpathan.content_calendar.model.Content;
//import com.atifpathan.content_calendar.model.Status;
//import com.atifpathan.content_calendar.model.Type;
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ContentCollectionRepository {
//
//    // we are just using an in memory list for now, need to replace with database next
//    private final List<Content> contentList = new ArrayList<>();
//
//    public ContentCollectionRepository() {
//    }
//
//    public List<Content> findAll() {
//        return this.contentList;
//    }
//
//    public Optional<Content> findById(Integer id) {
//        return this.contentList.stream().filter(c -> c.id().equals(id)).findFirst();
//    }
//
//    public void save(Content content) {
//        // remove the existing content before you add (which is essentially updating)
//        // the new updated content for that same id
//        contentList.removeIf(c -> c.id().equals(content.id()));
//        this.contentList.add(content);
//    }
//
//    @PostConstruct
//    // The PostConstruct annotation is used on a method that needs to be executed after
//    // dependency injection is done to perform any initialization. Basically allows us to setup
//    // dummy data for content right now to test our GET requests
//    private void init() {
//        Content c = new Content(1,
//                                "first blog",
//                                "first blog everrr!",
//                                Status.IDEA,
//                                Type.ARTICLE,
//                                LocalDateTime.now(),
//                                null,
//                                "");
//        contentList.add(c);
//    }
//
//    public boolean existsById(Integer id) {
//        return this.contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
//    }
//
//    public void deleteById(Integer id) {
//        contentList.removeIf(c -> c.id().equals(id));
//    }
//}
