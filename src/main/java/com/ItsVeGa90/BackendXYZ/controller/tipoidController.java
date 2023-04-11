package com.ItsVeGa90.BackendXYZ.controller;

import com.ItsVeGa90.BackendXYZ.dto.messagePer;
import com.ItsVeGa90.BackendXYZ.dto.tipoidDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionController;
import com.ItsVeGa90.BackendXYZ.facade.tipoidFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tipoid")
@CrossOrigin("*")
public class tipoidController {
    @Autowired
    private tipoidFacade tidFac;

    @PostMapping("/save")
    public ResponseEntity<messagePer> process(@RequestBody tipoidDTO tidDTO) throws exceptionController {
        messagePer message = new messagePer("0", "¡¡ Saved successfully !!", null);
        try {
            tidFac.process(tidDTO);
        } catch (Exception e) {
            message.setCode("1");
            message.setMessage("¡¡ Failed to save!!");
            throw new exceptionController(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<messagePer> delete(@RequestBody tipoidDTO tidDTO) throws exceptionController {
        messagePer message = new messagePer("0", "¡¡ Delete successfully !!", null);
        try {
            tidFac.delete(tidDTO);
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
            List<tipoidDTO> list = tidFac.selectAll();
            message.setData(list);
        } catch (Exception e) {
            throw new exceptionController(e);
        }
        return ResponseEntity.ok(message);
    }
}
