package com.example.myitemssearchk.data.mapper

interface BaseMapperService<R, D> {

    fun transform(type: R): D
}
