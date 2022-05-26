package com.mysquare.restoms.repository;

import java.util.List;
import com.mysquare.restoms.model.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountantRepo extends CrudRepository<CustomerDetails, Long> {

	@Query("select c from CustomerDetails c")
	public List<CustomerDetails> getCurrentCustDetailsDao();

	@Query("select c from CustomerDetails c where orderSubmit=0 and orderFlag=1 order by orderId")
	List<CustomerDetails> getProcessOrderDao();

	public CustomerDetails findFirstByTableNoOrderByOrderIdDesc(String tid);

	@Query("select c from CustomerDetails c where tableNo= ?1 and paid=0 and orderFlag=0 and orderSubmit=0")
	public List<CustomerDetails> getOrderDataDao(String tableId);

	@Modifying
	@Query("delete from CustomerDetails c where c.tableNo= ?1 and c.orderId= ?2")
	int deleteCustbyOid(String tid, int oid);

	@Modifying
	@Query("update CustomerDetails c set c.orderFlag=1 where c.tableNo= ?1")
	int setPlaceOrderFlag(String tid);

	@Modifying
	@Query("update CustomerDetails c set c.paid=1 where c.tableNo= ?1")
	int setPaidFlag(String tid);

	@Modifying
	@Query("update CustomerDetails set orderSubmit=1 where orderId= ?1")
	int deleteFromKitchenDao(int oid);

	@Query("select c from CustomerDetails c where tableNo= ?1 and orderFlag=1")
	List<CustomerDetails> getBillDao(String tid);

//	@Override
//	public List<CustomerDetails> getBillDao(String tid) {
//		/*String jpql="select sum(c.price)7'
//		 from CustomerDetails c where tableNo=:tid";
//		double total=sf.getCurrentSession().createQuery(jpql,Double.class).setParameter("tid", tid).getSingleResult();
//		System.out.println(total);*/
//		System.out.println("in getbill dao");
//		String jpql="";
//		List<CustomerDetails> li=sf.getCurrentSession().createQuery(jpql,CustomerDetails.class).setParameter("tid",tid).getResultList();
//		System.out.println("list is::"+li);
//		int totbill = 0;
//		if(!li.isEmpty()) {
//			totbill=sf.getCurrentSession().createSQLQuery(" call getBill(:tid)").setParameter("tid", tid).executeUpdate();
//		}
//		System.out.println("totbill is::" + String.valueOf(totbill));
//		return li;
//	}
}
