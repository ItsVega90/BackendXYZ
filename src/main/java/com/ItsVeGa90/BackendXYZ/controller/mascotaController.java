package com.ItsVeGa90.BackendXYZ.controller;

import com.ItsVeGa90.BackendXYZ.dto.mascotaDTO;
import com.ItsVeGa90.BackendXYZ.dto.messagePer;
import com.ItsVeGa90.BackendXYZ.exception.exceptionController;
import com.ItsVeGa90.BackendXYZ.facade.mascotaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/mascota")
@CrossOrigin("*")
public class mascotaController {
    @Autowired
    private mascotaFacade masFac;

    @PostMapping("/save")
    public ResponseEntity<messagePer> process(@RequestBody mascotaDTO masDTO) throws exceptionController {
        messagePer message = new messagePer("0", "¡¡ Saved successfully !!", null);
        try {
            masFac.process(masDTO);
        } catch (Exception e) {
            message.setCode("1");
            message.setMessage("¡¡ Failed to save!!");
            throw new exceptionController(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<messagePer> delete(@RequestBody mascotaDTO masDTO) throws exceptionController {
        messagePer message = new messagePer("0", "¡¡ Delete successfully !!", null);
        try {
            masFac.delete(masDTO);
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
            List<mascotaDTO> list = masFac.selectAll();
            message.setData(list);
        } catch (Exception e) {
            throw new exceptionController(e);
        }
        return ResponseEntity.ok(message);
    }
}
