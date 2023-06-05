package com.journal.journalspring.repositories;

import com.journal.journalspring.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
