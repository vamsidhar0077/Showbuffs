package com.showbuffs.repository;

import com.showbuffs.model.Checklist;
import com.showbuffs.model.ChecklistKey;
import org.springframework.data.repository.CrudRepository;

public interface ChecklistRepository extends CrudRepository<Checklist, ChecklistKey> {
}
