package apple.codeassessment.repo;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import apple.codeassessment.model.Employee;

public class MemoryStorageEmployeeRepo implements apple.codeassessment.di.repo.EmployeeRepo {

	private Map<Integer, Employee> dataSrc = new HashMap<>();
	AtomicInteger nextId = new AtomicInteger(0);
	
	@Override
	public Employee getEmployeeById(int id) {
		return dataSrc.getOrDefault(id, null);
	}

	@Override
	public Employee addOrUpdateEmployee(Employee e){
		if (e.getId() > 0) {
			if(dataSrc.containsKey(e.getId())) {
				dataSrc.put(e.getId(), e);
			}else {
				return null;
			}
		}else {
			e.setId(this.nextId.incrementAndGet());
			dataSrc.put(e.getId(), e);
		}
		return e;
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		if (this.dataSrc.remove(id) != null) {
			return true;
		}else {
			return false;
		}
	}

}
