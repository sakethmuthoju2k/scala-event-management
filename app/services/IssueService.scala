package services

import models.entity.Issue
import repositories.IssueRepository
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class IssueService @Inject() (
                              issueRepository: IssueRepository,
                              kafkaProducerFactory: KafkaProducerFactory
                            )(implicit executionContext: ExecutionContext) {
  def create(issue: Issue): Future[Long] = {
    issueRepository.create(issue).map(issue =>{
      kafkaProducerFactory.sendIssueReport(issue)   // SEND NOTIFICATON TO MANAGEMENT
      issue.id.get
    })
  }
}
