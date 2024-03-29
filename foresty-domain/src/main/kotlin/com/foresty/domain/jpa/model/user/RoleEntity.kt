package com.foresty.domain.jpa.model.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "role")
class RoleEntity(
    @Id
    @Column(name = "roleId", columnDefinition = "bigint comment 'Role ID'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "name", columnDefinition = "varchar(100) comment 'Role name'")
    val name: String,
) {

}