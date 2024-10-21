package com.example.data.repository

import android.util.Log
import com.example.data.mapper.BookMapper
import com.example.data.source.remote.BookDataSource
import com.example.domain.model.Book
import com.example.domain.repository.BookRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val dataSource: BookDataSource) :
    BookRepository {
    override suspend fun searchBook(query: String, display: Int): ArrayList<Book>? {
        return try {
            val response = dataSource.getSearchBooks(query, display)
            if (response.isSuccessful) {
                Log.e("[${javaClass.name}]", "success response body: ${response.body()}")
                response.body()
                    ?.let { BookMapper.mapperToBook(it) }
            } else {
                val errorMessage = response.errorBody()
                Log.e("[${javaClass.name}]", "Error message: $errorMessage")
                throw HttpException(response)
            }
        } catch (exception: IOException) {
            Log.e("[${javaClass.name}]", "Exception message: ${exception.message}")
            throw exception
        }
    }
}