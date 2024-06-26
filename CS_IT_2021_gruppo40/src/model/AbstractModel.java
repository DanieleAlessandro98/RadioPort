package model;

import model.contracts.IModel;

/**
 * Classe astratta del model
 * Si occupa di mettere a fattor comune (per ogni model concreto) il metodo isValidData
 * Inoltre ogni controller avr� una sua differente implementazione di quest'ultimo per verificare, per ogni modello, se i dati sono corretti
 * @author Alex
 *
 */
public abstract class AbstractModel implements IModel {

	/**
	 * Metodo astratto che si occuper� di verificare se i dati presenti per ogni oggetto del model � valido
	 */
	@Override
	abstract public boolean isValidData();

}
