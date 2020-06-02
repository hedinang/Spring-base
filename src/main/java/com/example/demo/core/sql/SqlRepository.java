//package com.example.demo.core.sql;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@org.springframework.stereotype.Repository
//@Transactional
//public interface SqlRepository<T, ID> extends JpaRepository<T, ID> {
//    @Query("update #{#entityName} t set t.delete = true where t.id = :id")
//    public void deleteById(Boolean logic, @Param("id") ID id);
//
//    @Query("select t from #{#entityName} t where t.delete = false and t.id= :id")
//    public Optional<T> findById(@Param("id") ID id);
//
//}
