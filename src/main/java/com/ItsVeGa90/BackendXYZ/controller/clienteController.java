package com.ItsVeGa90.BackendXYZ.controller;

import com.ItsVeGa90.BackendXYZ.dto.clienteDTO;
import com.ItsVeGa90.BackendXYZ.dto.messagePer;
import com.ItsVeGa90.BackendXYZ.exception.exceptionController;
import com.ItsVeGa90.BackendXYZ.facade.clienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")
public class clienteController {
    @Autowired
    private clienteFacade cliFac;

    @PostMapping("/save")
    public ResponseEntity<messagePer> process(@RequestBody clienteDTO cliDTO) throws exceptionController {
        messagePer message = new messagePer("0", "¡¡ Saved successfully !!", null);
        try {
            cliFac.process(cliDTO);
        } catch (Exception e) {
            message.setCode("1");
            message.setMessage("¡¡ Failed to save!!");
            throw new exceptionController(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<messagePer> delete(@RequestBody clienteDTO cliDTO) throws exceptionController {
        messagePer message = new messagePer("0", "¡¡ Delete successfully !!", null);
        try {
            cliFac.delete(cliDTO);
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
            List<clienteDTO> list = cliFac.selectAll();
            message.setData(list);
        } catch (Exception e) {
            throw new exceptionController(e);
        }
        return ResponseEntity.ok(message);
    }
}
