package br.dev.paduan.projeto02.service;

import org.springframework.stereotype.Service;

@Service
public class ContaService {

    public double getSaldo(int numeroConta) {
        if(numeroConta == 1){
            return 100;
        } else {
            return -1;
        }
    }

}
