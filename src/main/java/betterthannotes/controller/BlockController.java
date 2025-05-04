package betterthannotes.controller;

import betterthannotes.model.Block;
import betterthannotes.model.Page;
import betterthannotes.repository.BlockRepository;
import betterthannotes.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages/{pageId}/blocks")
@RequiredArgsConstructor
public class BlockController {

    private final BlockRepository blockRepository;
    private final PageRepository pageRepository;

    @GetMapping
    public List<Block> getBlocks(@PathVariable Long pageId) {
        return blockRepository.findByPageIdOrderByOrderIndexAsc(pageId);
    }

    @PostMapping
    public Block createBlock(@PathVariable Long pageId, @RequestBody Block block) {
        Page page = pageRepository.findById(pageId).orElseThrow();
        block.setPage(page);
        return blockRepository.save(block);
    }

    @PutMapping("/{blockId}")
    public Block updateBlock(@PathVariable Long pageId, @PathVariable Long blockId, @RequestBody Block updatedBlock) {
        Block block = blockRepository.findById(blockId).orElseThrow();
        block.setContent(updatedBlock.getContent());
        block.setOrderIndex(updatedBlock.getOrderIndex());
        return blockRepository.save(block);
    }

    @DeleteMapping("/{blockId}")
    public void deleteBlock(@PathVariable Long pageId, @PathVariable Long blockId) {
        blockRepository.deleteById(blockId);
    }
}