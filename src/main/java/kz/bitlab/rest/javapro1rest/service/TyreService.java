package kz.bitlab.rest.javapro1rest.service;

import kz.bitlab.rest.javapro1rest.dto.TyreDto;
import kz.bitlab.rest.javapro1rest.mapper.TyreMapper;
import kz.bitlab.rest.javapro1rest.model.Tyre;
import kz.bitlab.rest.javapro1rest.repository.TyreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TyreService {

    private final TyreRepository tyreRepository;
    private final TyreMapper tyreMapper;

    public List<TyreDto> getTyres(){
        List<Tyre> tyres = tyreRepository.findAll();
        List<TyreDto> tyreDtoList = new ArrayList<>();
        tyres.forEach(tyre -> tyreDtoList.add(tyreMapper.toDto(tyre)));
        return tyreDtoList;
    }

    public TyreDto addTyre(TyreDto dto){
        Tyre tyre = tyreMapper.toEntity(dto);
        return tyreMapper.toDto(tyreRepository.save(tyre));
    }

    public TyreDto addTyre(Tyre tyre){
        return tyreMapper.toDto(tyreRepository.save(tyre));
    }

    public TyreDto getTyre(Long id){
        return tyreMapper.toDto(tyreRepository.findById(id).orElseThrow());
    }

    public TyreDto updateTyre(TyreDto dto){
        return tyreMapper.toDto(tyreRepository.save(tyreMapper.toEntity(dto)));
    }

    public void deleteTyre(Long id){
        tyreRepository.deleteById(id);
    }
}