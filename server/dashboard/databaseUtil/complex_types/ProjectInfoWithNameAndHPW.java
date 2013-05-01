package dashboard.databaseUtil.complex_types;

public class ProjectInfoWithNameAndHPW {

	public int projectId;
	public int HPW;
	public boolean activeWeekend;
	
	public ProjectInfoWithNameAndHPW(int projectId, int HPW, boolean activeWeekend){
		this.projectId = projectId;
		this.HPW = HPW;
		this.activeWeekend = activeWeekend;
	}
}
