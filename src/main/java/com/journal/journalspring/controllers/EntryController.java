package com.journal.journalspring.controllers;

import com.journal.journalspring.models.Entry;
import com.journal.journalspring.repositories.EntryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entries")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping
    public List<Entry> list() { return entryRepository.findAll(); }

    @GetMapping
    @RequestMapping("{id}")
    public Entry get(@PathVariable Long id) { return entryRepository.findById(id).get(); }

    @PostMapping
    public Entry create(@RequestBody final Entry entry) { return entryRepository.saveAndFlush(entry); }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        entryRepository.deleteById(id);
    }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.PUT)
    public Entry update(@PathVariable Long id, @RequestBody Entry entry) {
        Entry existingEntry = entryRepository.findById(id).get();
        BeanUtils.copyProperties(entry, existingEntry, "entryId");
        return entryRepository.saveAndFlush(existingEntry);
    }
}
