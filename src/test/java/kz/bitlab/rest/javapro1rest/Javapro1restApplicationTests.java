package kz.bitlab.rest.javapro1rest;

import kz.bitlab.rest.javapro1rest.dto.TyreDto;
import kz.bitlab.rest.javapro1rest.mapper.TyreMapper;
import kz.bitlab.rest.javapro1rest.model.Tyre;
import kz.bitlab.rest.javapro1rest.repository.TyreRepository;
import kz.bitlab.rest.javapro1rest.service.TyreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Javapro1restApplicationTests {

	@Autowired
	private TyreMapper tyreMapper;

	@Autowired
	private TyreService tyreService;

	@Autowired
	private TyreRepository tyreRepository;

	@Test
	void testTyreMapToDto(){
		Tyre tyre = new Tyre();
		tyre.setId(55L);
		tyre.setManufacturer("Some Manufacturer");
		tyre.setName("Brat Pitt");
		tyre.setPrice(4444);
		tyre.setProfile("ProfileBek");

		TyreDto tyreDto = tyreMapper.toDto(tyre);
		Assertions.assertNotNull(tyreDto);
		Assertions.assertEquals(tyre.getId(), tyreDto.getId());
		Assertions.assertEquals(tyre.getManufacturer(), tyreDto.getManufacturer());
		Assertions.assertEquals(tyre.getName(), tyreDto.getTyreName());
		Assertions.assertEquals(tyre.getPrice(), tyreDto.getPrice());
		Assertions.assertEquals(tyre.getProfile(), tyreDto.getTyreProfile());
	}

	@Test
	void checkTyreGetAll(){
		Tyre tyre = new Tyre();
		tyre.setName("Brad Pitt");
		tyre.setPrice(23222);
		tyre.setManufacturer("Kazakhstan");
		tyre.setProfile("Almaty");

		tyreRepository.deleteAll();
		tyreRepository.save(tyre);

		List<TyreDto> tyres = tyreService.getTyres();
		Assertions.assertNotNull(tyres);
		Assertions.assertTrue(tyres.size()>0);
		Assertions.assertNotNull(tyres.get(0));
		Assertions.assertEquals(tyres.get(0).getId(), tyre.getId());
		Assertions.assertEquals(tyres.get(0).getManufacturer(), tyre.getManufacturer());
		Assertions.assertEquals(tyres.get(0).getPrice(), tyre.getPrice());
		Assertions.assertEquals(tyres.get(0).getTyreName(), tyre.getName());
		Assertions.assertEquals(tyres.get(0).getTyreProfile(), tyre.getProfile());

		tyreRepository.deleteAll();
	}

}
