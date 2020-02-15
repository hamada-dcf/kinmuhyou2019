package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Kinmuhyou2019Repository extends JpaRepository<Kinmuhyou2019Entity, Integer>{

	//コントローラで呼び出す
	public Kinmuhyou2019Entity findByMailaddress(String mailaddress);
}