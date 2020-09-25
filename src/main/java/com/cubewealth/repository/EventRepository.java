package com.cubewealth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cubewealth.model.Event;


public interface EventRepository extends CrudRepository<Event, Long>{
	@Query("select e from Event e where e.userid = ?1 and e.noun = 'bill' and e.verb = 'pay'")
	List<Event> findByUseridAndBillPay(Long id);
}
