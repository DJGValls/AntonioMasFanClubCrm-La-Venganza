package com.antoniomasfanclub.repository;

import com.antoniomasfanclub.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account getAccountById(Integer id);

    @Query("SELECT avg(a.employeeCount) from Account a")
    Integer getMeanEmployeeCount();
    @Query("SELECT max(a.employeeCount) from Account a")
    Integer getMaxEmployeeCount();
    @Query("SELECT min(a.employeeCount) from Account a")
    Integer getMinEmployeeCount();

    @Query("SELECT avg(size(a.opportunityList)) from Account a")
    Integer getMeanOpportunityByAccount();
    @Query("SELECT max(size(a.opportunityList)) from Account a")
    Integer getMaxOpportunityByAccount();
    @Query("SELECT min(size(a.opportunityList)) from Account a")
    Integer getMinOpportunityByAccount();
}
