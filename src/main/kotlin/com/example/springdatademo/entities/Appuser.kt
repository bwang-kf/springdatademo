package com.example.springdatademo.entities

import org.springframework.data.annotation.Id

data class Appuser(@Id
           var id: Long? = null,
                   var email: String,
                   var username: String,
                   var password: String) {
}