package com.ItsVeGa90.BackendXYZ.controller;

import com.ItsVeGa90.BackendXYZ.dto.especieDTO;
import com.ItsVeGa90.BackendXYZ.dto.messagePer;
import com.ItsVeGa90.BackendXYZ.exception.exceptionController;
import com.ItsVeGa90.BackendXYZ.facade.especieFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/especie")
@CrossOrigin("*")
public class especieController {
    @Autowired
    private especieFacade espFac;

    @PostMapping("/save")
    public ResponseEntity<messagePer> process(@RequestBody especieDTO espDTO) throws exceptionController {
        messagePer message = new messagePer("0", "¡¡ Saved successfully !!", null);
        try {
            espFac.process(espDTO);
        } catch (Exception e) {
            message.setCode("1");
            message.setMessage("¡¡ Failed to save!!");
            throw new exceptionController(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<messagePer> delete(@RequestBody especieDTO espDTO) throws exceptionController {
        messagePer message = new messagePer("0", "¡¡ Delete successfully !!", null);
        try {
            espFac.delete(espDTO);
        } catch (Exception e) {
            message.setCode("1");
            message.setMessage("¡¡ Failed to delete !!" + e.getMessage());
            throw new exceptionController(e);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/selectall")
    public ResponseEntity<messagePer> selectAll() throws exceptionController {
        messagePer message = new messagePer("0", "¡¡ Query successfully !!", null);
        try {
            List<especieDTO> list = espFac.selectAll();
            message.setData(list);
        } catch (Exception e) {
            throw new exceptionController(e);
        }
        return ResponseEntity.ok(message);
    }
}
