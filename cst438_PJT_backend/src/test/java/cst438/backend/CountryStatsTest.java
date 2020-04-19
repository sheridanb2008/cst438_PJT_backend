package cst438.backend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import static org.mockito.BDDMockito.given;

import cst438backend.CaseController;
import cst438backend.CaseRepository;
import cst438backend.CountryStats;
import cst438backend.CountryStatsRepository;

import cst438backend.CovidStatsRepository;
import cst438backend.Cst438PjtBackendApplication;

import org.springframework.test.context.ContextConfiguration;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Cst438PjtBackendApplication.class)
@WebMvcTest(CaseController.class)
public class CountryStatsTest {

	@MockBean
	CaseRepository caseRepository;
	
	@MockBean
	CovidStatsRepository statsRepository;
	
	@MockBean
	CountryStatsRepository countryStatsRepository;
	
	@Autowired
	private MockMvc mvc;
	
	private JacksonTester<CountryStats> json;
	
	
	@Before
	public void setup() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		JacksonTester.initFields(this, mapper);
	}
	
	
	@Test
	public void test() {
		CountryStats attempt = new CountryStats("US",1,2,3,4,5,java.sql.Date.valueOf("2020-04-01"));
		CountryStats expected = new CountryStats("US",1,2,3,4,5,java.sql.Date.valueOf("2020-04-01"));
		given(countryStatsRepository.getCountryTotals("US")).willReturn(expected);		
		
		try {
			
			MockHttpServletResponse response = mvc.perform(		 
			        get("/covid/latest/US").contentType(MediaType.APPLICATION_JSON)
			                .content(json.write(attempt).getJson()))
			        .andReturn().getResponse();
			assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
			String contentStr = response.getContentAsString();
			String expectedStr = json.write(expected).getJson();
			assertThat(contentStr).isEqualTo(expectedStr);
			//System.out.println(contentStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}
