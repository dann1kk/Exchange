package orange.test.exchange.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import orange.test.exchange.mapper.NumerarMapper;
import orange.test.exchange.model.domain.Numerar;
import orange.test.exchange.model.dto.NewNumerarDTO;
import orange.test.exchange.service.NumerarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/numerar")
@RequiredArgsConstructor
public class NumerarController {

    private final NumerarService numerarService;
    private final NumerarMapper numerarMapper;

    @ApiOperation("Corectare numerar")
    @PutMapping
    public Mono<ResponseEntity<Void>> update(@RequestBody NewNumerarDTO newNumerarDTO) {
        Numerar numerar = numerarMapper.toEntity(newNumerarDTO);
        return numerarService.update(numerar).map(__ -> ResponseEntity.ok().build());
    }
}
