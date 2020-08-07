package com.packsendme.roadway.bre.rule.sa.test.categoryC;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.common.constants.generic.MetricUnitMeasurement_Constants;
import com.packsendme.lib.common.constants.way.Roadway_SA_Constants;
import com.packsendme.roadway.bre.model.category.CategoryRule;
import com.packsendme.roadway.bre.model.category.CategoryType;
import com.packsendme.roadway.bre.model.location.Location;
import com.packsendme.roadway.bre.model.vehicle.VehicleRule;
import com.packsendme.roadway.bre.model.vehicle.VehicleType;

public class CategoryBRE_CatC_SA {
	
	/*===============================================================================================================================
	 *  V E H I C L E 
	 *===============================================================================================================================
	 */
	@Test
	CategoryRule getCategory_C_Rule() throws URISyntaxException, IOException {

		CategoryType categoryType = new CategoryType();
		categoryType.typeCategory = "Semi-Pesado";
		
		CategoryRule categoryBRE = new CategoryRule("Cat_C",categoryType, getLocation(), 3.0,6.0,2,MetricUnitMeasurement_Constants.tonelada_UnitMeasurement,
				MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, getVehicle());
				
		ObjectMapper mapper = new ObjectMapper();
		String jsonSouthAmerica = mapper.writeValueAsString(categoryBRE);
		System.out.println(jsonSouthAmerica);
   		Assert.notNull(jsonSouthAmerica);
   		return categoryBRE;
	}
	
	public List<VehicleRule> getVehicle() {
		List<VehicleRule> vehicleL = new ArrayList<VehicleRule>(); 
		List<String> bodyworkL = getBodyWork();
		VehicleRule vehicle_model1 = new VehicleRule(getVehicleType(1).type_vehicle, bodyworkL, 6.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		VehicleRule vehicle_model2 = new VehicleRule(getVehicleType(2).type_vehicle, bodyworkL, 6.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		VehicleRule vehicle_model3 = new VehicleRule(getVehicleType(3).type_vehicle, bodyworkL, 6.0, 2, MetricUnitMeasurement_Constants.tonelada_UnitMeasurement, 0);
		vehicleL.add(vehicle_model1);
		vehicleL.add(vehicle_model2);
		vehicleL.add(vehicle_model3);
		return vehicleL;
	}
	
	public List<String>  getBodyWork() {
		List<String> bodywork_vehicleL = new ArrayList<String>();
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_BASCULANTE);
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_BAU_ALIMINIO);
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_BAU_FRIGORIFICO);
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_BAU_LONADO);
		bodywork_vehicleL.add(Roadway_SA_Constants.BODYWORK_GRADE_BAIXA);
		return bodywork_vehicleL;
	}
	
	
	public VehicleType getVehicleType(int type) {
		VehicleType vehicleType = new VehicleType();
		
		if(type == 1) {
			vehicleType.type_vehicle = Roadway_SA_Constants.ROADWAY_URBANO;
		}
		else if(type == 2) {
			vehicleType.type_vehicle = Roadway_SA_Constants.ROADWAY_TOCO12;
		} 
		else if(type == 3) {
			vehicleType.type_vehicle = Roadway_SA_Constants.ROADWAY_TOCO16;
		} 
		return vehicleType;
	}
	
	/*===============================================================================================================================
	 *  LOCATION
	 *===============================================================================================================================
	 */
	
	public Location getLocation() {
		Location locationObj = new Location("Brazil","","","");
		return locationObj;
	}

}
