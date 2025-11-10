package strategy;

import entidades.PersonagemAbstrato;

public interface AtaqueStrategy {
	void atacar(PersonagemAbstrato atacante, PersonagemAbstrato alvo);
}
