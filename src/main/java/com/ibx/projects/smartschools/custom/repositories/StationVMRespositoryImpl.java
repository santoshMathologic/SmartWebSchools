package com.ibx.projects.smartschools.custom.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibx.projects.smartschools.custom.models.StationVM;
import com.ibx.projects.smartschools.custom.utils.SelectViewModel;
import com.ibx.projects.smartschools.custom.utils.SelectionDetails;


@Repository
public class StationVMRespositoryImpl implements StationVMRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public StationVMRespositoryImpl() {
		
	}

	@Transactional(readOnly = true)
	@Override
	public SelectViewModel listStations(String code, String name,String sort, Long page, Long size) {
		
		String FROM = " FROM station AS s"
				+ " WHERE ( :code IS NULL OR s.code = :code ) "
				+ " AND ( :name IS NULL OR s.name LIKE :name ) ";
				
		
		String query1 = 
				"SELECT COUNT(s.id) "
				+ FROM;
		
		Query query1f = entityManager.createNativeQuery(query1);
		query1f.setParameter("code", code);
		query1f.setParameter("name", (name!=null)?"%"+ name +"%":null);
		
		
		
		Long totalElements = ((java.math.BigInteger) query1f.getSingleResult())
				.longValue();
		Long startIndex = page*size;
		Long totalPages = totalElements / size;
		Long currentPage = page;
		String baseItemRestUri = "/api/stations/";
		SelectViewModel result = new SelectViewModel(StationVM.class,
				new SelectionDetails(totalElements, startIndex, currentPage,
						totalPages, baseItemRestUri), null);
		if (totalElements > 0) {
			
			if(sort!=null && sort.isEmpty()){
				sort = null;
			}
			
			String query2 = 
					  "SELECT s.id as Id,s.name AS Name,s.code as Code,s.number_of_beds as noOfBeds, s.head_station_sign_off_duration as headStationSignOffDuration,"
					+ "s.head_station_sign_on_duration as headStationSignOnDuration,s.out_station_sign_off_duration as outStationSignOffDuration,"
					+ "s.out_station_sign_on_duration as outStationSignOnDuration"
					+ FROM
					
					+ " ORDER BY "+sort
					+ " LIMIT :start, :offset";
			Query query2f = entityManager.createNativeQuery(query2);
			query2f.setParameter("code", code);
			query2f.setParameter("name", (name!=null)?"%"+ name +"%":null);
			
			
			query2f.setParameter("start", page*size);
			query2f.setParameter("offset", size);
			try {
				result.setData(query2f.getResultList());
			} catch (Exception ex) {
				System.out.println("ERROR in QUERY: " + ex.getMessage());
			}
		}

		
		return result;
		
			
	}

	@Override
	public SelectViewModel findByCode(String code, String sort, Long page, Long size) {
		

		String query1 = 
				"SELECT COUNT(s.id) "
				+ " FROM station AS s"
				+ " WHERE :code IS NULL OR s.code = :code";
		
		Query query1f = entityManager.createNativeQuery(query1);
		query1f.setParameter("code", code);
		
		Long totalElements = ((java.math.BigInteger) query1f.getSingleResult())
				.longValue();
		Long startIndex = page*size;
		Long totalPages = totalElements / size;
		Long currentPage = page;
		String baseItemRestUri = "/api/stations/";
		SelectViewModel result = new SelectViewModel(StationVM.class,
				new SelectionDetails(totalElements, startIndex, currentPage,
						totalPages, baseItemRestUri), null);
		if (totalElements > 0) {
			
			if(sort!=null && sort.isEmpty()){
				sort = null;
			}
			
			String query2 = 
					  "SELECT s.id as Id,s.code as Code,s.name AS Name,s.number_of_beds as noOfBeds, s.head_station_sign_off_duration as headStationSignOffDuration,"
					+ " s.head_station_sign_on_duration as headStationSignOnDuration,s.out_station_sign_off_duration as outStationSignOffDuration,"
					+ " s.out_station_sign_on_duration as outStationSignOnDuration"
					+ " FROM station AS s"
					+ " WHERE :code IS NULL OR s.code = :code ";
			Query query2f = entityManager.createNativeQuery(query2);
			query2f.setParameter("code", code);
			
			try {
				result.setData(query2f.getResultList());
			} catch (Exception ex) {
				System.out.println("ERROR in QUERY: " + ex.getMessage());
			}
		}
		
		
		return result;
	}

}
