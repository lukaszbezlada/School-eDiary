import { browser, by, element } from 'protractor';

export class AppPage {
  // @ts-ignore
  async navigateTo(): Promise<unknown> {
    return browser.get(browser.baseUrl);
  }

  // @ts-ignore
  async getTitleText(): Promise<string> {
    return element(by.css('app-root .content span')).getText();
  }
}
