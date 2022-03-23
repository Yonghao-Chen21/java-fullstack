package com.careerit.ymal;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import lombok.Data;

@Data
class Tenant {
	private String name;
	private String dbName;
	private String user;
	private String password;
	private int port;
	private String host;
}

@Data
class TenantList{
	private List<Tenant> tenants;//attribute name must be the same with yaml file.
	
}

public class TenantService {
	public Map<String,Tenant> rs= new HashMap<>();
	public List<Tenant> list;
	public void loadTenants() {
		ObjectMapper objMapper = new ObjectMapper(new YAMLFactory());
		TenantList tlist = null;
		try {
			tlist = objMapper.readValue(this.getClass().getResourceAsStream("/tenants-data.yaml"),TenantList.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		list = tlist.getTenants();
	}
	
	public void getMap(){
		list.stream().forEach(t->rs.put(t.getName(), t));
	}
	
	public void printTenant(String name) {
		System.out.println(rs.get(name));
	}
	
	public static void main(String[] args) {
		TenantService obj = new TenantService();
		obj.loadTenants();
		obj.getMap();
		obj.printTenant("Dell");
	}

}
