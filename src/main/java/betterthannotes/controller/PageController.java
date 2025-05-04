package betterthannotes.controller;

import betterthannotes.model.Page;
import betterthannotes.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
@RequiredArgsConstructor
public class PageController {

    private final PageRepository pageRepository;

    @GetMapping
    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Page getPage(@PathVariable Long id) {
        return pageRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Page createPage(@RequestBody Page page) {
        return pageRepository.save(page);
    }

    @PutMapping("/{id}")
    public Page updatePage(@PathVariable Long id, @RequestBody Page updatedPage) {
        Page page = pageRepository.findById(id).orElseThrow();
        page.setTitle(updatedPage.getTitle());
        return pageRepository.save(page);
    }

    @DeleteMapping("/{id}")
    public void deletePage(@PathVariable Long id) {
        pageRepository.deleteById(id);
    }
}