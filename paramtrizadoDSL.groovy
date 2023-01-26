job('ejemplo-job-DSL') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  	scm {
      git('https://github.com/macloujulian/jenkins.job.parametrizado','main'){ node ->
        node / gitConfigName('ferney jerez')
        node / gitConfigEmail('ferney9212@gamil.com')
      }
    }
  parameters {
  	 	stringParam('nombre',defaultValue='Ferney',description = 'Parametro de cadena para el Job Booleano')
     	choiceParam('Planeta', ['Mercurio', 'Venus', 'Tierra','Marte'])
		  choiceParam('Other', ['Ferney J (default)', 'option 2', 'option 3'], 'my description')
    	booleanParam('agente',false)
  }
  triggers {
  		cron('H/7 * * * *')
  }
  steps {
  	shell("bash jobscript.sh")
  }
  publishers{
  	mailer('ferney9212@gmail.com',true,true)
  }
  
 }
