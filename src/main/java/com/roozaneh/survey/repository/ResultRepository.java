package com.roozaneh.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.roozaneh.survey.domain.Result;
/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 2:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
}
