package betterthannotes.repository;

import betterthannotes.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Long> {
    List<Block> findByPageIdOrderByOrderIndexAsc(Long pageId);
}