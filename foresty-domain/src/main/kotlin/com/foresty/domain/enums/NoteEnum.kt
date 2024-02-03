package com.foresty.domain.enums

import com.fasterxml.jackson.annotation.JsonCreator

class NoteEnum {

    enum class Star(
        val code: String,
        val description: String
    ) {
        STAR1("1STAR", "1 star"),
        STAR2("2STAR", "2 star"),
        STAR3("3STAR", "3 star"),
        STAR4("4STAR", "4 star"),
        STAR5("5STAR", "5 star");

        companion object {
            @JvmStatic
            @JsonCreator
            fun from(code: String) =
                entries.toTypedArray()
                    .find {
                        it.code == code
                    }
        }
    }



}