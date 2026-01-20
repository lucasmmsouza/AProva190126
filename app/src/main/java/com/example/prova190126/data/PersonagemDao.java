package com.example.prova190126.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PersonagemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserirTodos(List<Personagem> personagens);

    @Query("SELECT * FROM tabela_personagens LIMIT :quantidade")
    List<Personagem> obterPersonagens(int quantidade);

    @Query("SELECT COUNT(*) FROM tabela_personagens")
    int contarPersonagens();

    @Query("SELECT * FROM tabela_personagens")
    List<Personagem> obterTodos();
}

//documentacao
//@Dao
//public interface UserDao {
//    @Query("SELECT * FROM user")
//    List<User> getAll();
//
//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    List<User> loadAllByIds(int[] userIds);
//
//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    User findByName(String first, String last);
//
//    @Insert
//    void insertAll(User... users);
//
//    @Delete
//    void delete(User user);
//}