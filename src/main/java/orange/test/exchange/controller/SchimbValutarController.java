package orange.test.exchange.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import orange.test.exchange.mapper.SchimbValutarMapper;
import orange.test.exchange.model.domain.Numerar;
import orange.test.exchange.model.domain.SchimbValutar;
import orange.test.exchange.model.dto.NewSchimbValutarDTO;
import orange.test.exchange.repository.NumerarRepository;
import orange.test.exchange.repository.SchimbValutarRepository;
import orange.test.exchange.service.SchimbValutarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/schimb")
@RequiredArgsConstructor
public class SchimbValutarController {

    private final SchimbValutarMapper schimbValutarMapper;
    private final SchimbValutarService schimbValutarService;

    @ApiOperation("Cumparare valuta straina")
    @PostMapping
    public Mono<ResponseEntity<Void>> create(@RequestBody NewSchimbValutarDTO newSchimbValutarDTO) {
        SchimbValutar schimbValutar = schimbValutarMapper.toEntity(newSchimbValutarDTO);
        return schimbValutarService.create(schimbValutar).map(__ -> ResponseEntity.ok().build());
    }
}
