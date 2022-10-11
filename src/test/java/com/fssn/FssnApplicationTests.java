package com.fssn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.fssn.exceptions.InputException;
import com.fssn.exceptions.LengthException;
import com.fssn.models.Fssn;
import com.fssn.service.FssnService;
import com.fssn.service.FssnServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FssnService.class)
public class FssnApplicationTests {

	@InjectMocks
	private FssnServiceImpl fssnService;

	/****
	 * Start
	 */

	@Test
	public void shouldSetCountryCodetFssn() throws Exception {

		Fssn fssn = new Fssn();
		fssn.setCountry_code("FI");
		fssn.setSsn("220222-105M");
		fssn.setCountry_code("GER");
		assertThat(fssn.getCountry_code()).isEqualTo("GER");

	}

	@Test
	public void shouldSetFssn() throws Exception {

		Fssn fssn = new Fssn();
		fssn.setCountry_code("FI");
		fssn.setSsn("220222-105M");
		fssn.setSsn("220222-105K");
		assertThat(fssn.getSsn()).isEqualTo("220222-105K");

	}

	@Test
	public void contructorTestFssn() throws Exception {

		Fssn fssn = new Fssn("220222-105M", "FI");

		assertThat(fssn).isInstanceOf(Fssn.class);
		assertThat(fssn.getCountry_code()).isEqualTo("FI");
		assertThat(fssn.getSsn()).isEqualTo("220222-105M");

	}

	@Test
	public void fssnServiceTest() throws Exception {
		Fssn fssn = new Fssn("010218-234E", "FI");
		assertThat(fssnService.validate(fssn).getResponse()).isTrue();
	}

	@Test
	public void failedResponseTest() throws Exception {
		Fssn fssn = new Fssn("010218-234M", "FI");
		assertThat(fssnService.validate(fssn).getResponse()).isFalse();
	}

	@Test
	public void failedDOBTest() throws Exception {
		Fssn fssn = new Fssn("310418-234E", "FI");
		assertThat(fssnService.validate(fssn).getResponse()).isFalse();
	}

	@Test
	void LengthExceptionTest() throws Exception {

		Fssn fssn = new Fssn("0102182341212321E", "FI");

		Assertions.assertThrows(LengthException.class, () -> fssnService.validate(fssn));

	}

	@Test
	void LengthExceptionTest2() throws Exception {

		Fssn fssn = new Fssn("310418-234E", "FIwwew");

		Assertions.assertThrows(LengthException.class, () -> fssnService.validate(fssn));

	}

	@Test
	void InputExceptionTest() throws Exception {

		Fssn fssn = new Fssn("k10e18-234E", "FI");

		Assertions.assertThrows(InputException.class, () -> fssnService.validate(fssn));

	}

}
