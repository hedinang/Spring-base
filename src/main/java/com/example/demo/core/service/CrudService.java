//package com.example.demo.core.service;
//
//import com.example.demo.core.mongoDb.MongoDbRepository;
//import com.example.demo.model.rabbitMq.EventSourcing;
//import com.example.demo.core.sql.SqlRepository;
//import com.google.gson.Gson;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.kafka.core.KafkaTemplate;
//
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.util.List;
//import java.util.Optional;
//
//public class CrudService<T, ID extends Serializable> {
//    public Class<T> entityClass;
//    @Autowired
//    SqlRepository sqlRepository;
//    @Autowired
//    MongoDbRepository mongoDbRepository;
//    @Autowired
//    RabbitTemplate rabbitTemplate;
//    @Autowired
//    KafkaTemplate kafkaTemplate;
//
//    public CrudService() {
//        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
//                .getActualTypeArguments()[0];
//    }
//
//    public T create(T t) {
//        T result = (T) sqlRepository.save(t);
//        return result;
//    }
//
//    public T read(ID id) {
//        Optional<T> result = sqlRepository.findById(id);
//        return result.get();
//    }
//
//    public T update(T t) {
//        T result = (T) sqlRepository.save(t);
//        return t;
//    }
//
//    public void delete(ID id) {
//        sqlRepository.deleteById(true, id);
//    }
//
//    public List<T> getAll(T t) {
//        Example<T> example = Example.of(t);
//        return sqlRepository.findAll(example);
//    }
//
//    public void createEvent(int eventType, T t) {
//        mongoDbRepository.save(t);
//        putToKafka(eventType, t);
//    }
//
////    protected void putToRabbit(String eventType, T t) {
////        try {
////            if (t != null) {
////                EventSourcing eventSourcing = new EventSourcing();
////                eventSourcing.eventType = eventType;
////                eventSourcing.data = t;
////                rabbitTemplate.convertAndSend("topic", entityClass.getSimpleName(), new Gson().toJson(eventSourcing));
////            }
////        } catch (Exception e) {
////
////        }
////    }
//
//    protected void putToKafka(int eventType, T t) {
//        try {
//            if (t != null) {
//                EventSourcing eventSourcing = new EventSourcing();
//                eventSourcing.eventType = eventType;
//                eventSourcing.data = t;
//                kafkaTemplate.send("topic", entityClass.getSimpleName(), new Gson().toJson(eventSourcing));
//            }
//        } catch (Exception e) {
//
//        }
//    }
//
//}
