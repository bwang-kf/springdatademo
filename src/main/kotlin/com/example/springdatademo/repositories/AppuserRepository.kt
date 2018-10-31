package com.example.springdatademo.repositories

import org.springframework.data.repository.CrudRepository
import com.example.springdatademo.entities.Appuser

interface AppuserRepository : CrudRepository<Appuser, Long>