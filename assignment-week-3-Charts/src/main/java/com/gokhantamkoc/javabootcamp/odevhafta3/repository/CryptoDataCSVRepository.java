package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;


public class CryptoDataCSVRepository implements CSVRepository {
	
	private final String COMMA_DELIMITER = ",";

	@Override
	public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
		List<Candle> candles = new ArrayList<Candle>();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		// Bu alandan itibaren kodunuzu yazabilirsiniz
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		
			String line;
			br.readLine();
			
			while ((line = br.readLine()) != null) {

				//unix,date,symbol,open,high,low,close,volume,tradecount	

				String[] values = line.split(COMMA_DELIMITER);
				
				Candle candleObject=new Candle(0, 0, 0, 0, 0, 0);	

				candleObject.setTime(Long.parseLong(values[0]));
				candleObject.setOpen(Double.parseDouble(values[3]));
				candleObject.setHigh(Double.parseDouble(values[4]));
				candleObject.setLow(Double.parseDouble(values[5]));
				candleObject.setClose(Double.parseDouble(values[6]));
				candleObject.setVolume(Double.parseDouble(values[7]));
				
				candles.add(candleObject);
				
			}
			br.close();
		}
		
		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
